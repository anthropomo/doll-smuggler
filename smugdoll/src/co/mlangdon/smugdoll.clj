(ns co.mlangdon.smugdoll
  (:gen-class))

(def dolls [
	["luke" 9 150]
	["anthony" 13 35]
	["candice" 153 200]
	["dorothy" 50 160]
	["puppy" 15 60]
	["thomas" 68 45]
	["randal" 27 60]
	["april" 39 40]
	["nancy" 23 30]
	["bonnie" 52 10]
	["marc" 11 70]
	["kate" 32 30]
	["tbone" 24 15]
	["granny" 48 10]
	["uma" 73 40]
	["grumpkin" 42 70]
	["dusty" 43 75]
	["grumpy" 22 80]
	["eddie" 7 20]
	["tory" 18 12]
	["sally" 4 50]
	["babe" 30 10]] )

(def max-weight 400)

(defn make-dynamic-table [items weight]
  (loop [v (transient [(vec(repeat (+ weight 1) 0))]) d 1]
    (if (< d (+ (count items) 1))
      (recur
        (conj! v 
          (loop [u (transient [0]) w 1]
		        (if (< w (+ weight 1))
		          (recur
                (conj! u 
                  (if (> ((items (- d 1)) 1) w)
		                ((v (- d 1)) w)
                    (max
                      ((v (- d 1)) w)
                      (+
                        ((v (- d 1)) (- w ((items (- d 1)) 1)))
		                    ((items (- d 1)) 2)
                      )))) 
                (inc w)
              )
		          (persistent! u))))
        (inc d)
      )      
      (persistent! v))))

(defn was-added [table cnt weight]
  (not= (get (get table cnt) weight) (get (get table (- cnt 1)) weight)))
  

(defn find-optimum 
  [table items weight]
  (loop [_weight weight cnt (count items) v (transient [])]
    (if (> cnt 0)
	    (recur 
        (if (was-added table cnt _weight)
		      (- _weight ((items (- cnt 1)) 1))
          _weight)
        (dec cnt)
        (if (was-added table cnt _weight)
          (conj! v (items (- cnt 1)))
          v))
      (persistent! v)))
  )

(defn pretty-print [preamble header output]
  (do
    (doseq
      [i preamble]
      (do
		    (println (format "    %s" i))
		    (println))) 
    (println (apply format "    %-9s%5s%6s" header))
    (doseq
      [i output]
      (println (format "    %-8s%5d%6d" (i 0) (i 1) (i 2))))
    (println)
))

(defn knapsack [items weight]
   (find-optimum (make-dynamic-table items weight) items weight)
)

(defn -main
  "docstring goes here"
  [& args]
  (println)
  (println "*** Doll Smuggler ***")
  (println)
  (pretty-print
    '("max weight: 400" "available dolls:")
    '("name" "weight" "value")
    dolls
    )
  (pretty-print 
    ["packed dolls:"]
    ["name" "weight" "value"]
    (knapsack dolls max-weight)))
