(comment "This is a dynamic programming solution to the knapsack problem as presented here:
          https://github.com/micahalles/doll-smuggler
          To test this implementation against arbitrary datasets, use the 'knapsack' function
          with args [dataset weight], where 'dataset' is vector of [name weight value] and 'weight'
          is the maximum weight available.")

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
	["babe" 30 10]])

(def max-weight 400)

(comment "An implementation of the 'dynamic programming' solution to the knapsack problem.
          A table is created -- number of items X integer weight. Each cell in the table represents
          the optimum total value if that item number and weight were maximum of each.")
(defn make-dynamic-table [items weight]
  ; Outer loop: one iteration for each available item (22).
  ; Each iteration adds a vector of 401 Ints to 'v'.
  ; We use transient here to avoid creating a new vector on each iteration.
  (loop [v (transient [(vec(repeat (+ weight 1) 0))]) d 1]
    (if (< d (+ (count items) 1))
      (recur
        ; Here we add the result of inner loop to 'v'. Note the use of 'conj!'
        ; for the transient vector.
        (conj! v 
          ; Inner loop: one iter for each possible weight (400).
          (loop [u (transient [0]) w 1]
		        (if (< w (+ weight 1))
		          (recur
                (conj! u 
                  ; If the weight of the item at (d - 1) is > current weight...
                  (if (> ((items (- d 1)) 1) w)
                    ; then set this cell to the value of the previous item at the same weight 
		                ((v (- d 1)) w)
                    ; else set it to the max of:
                    (max
                      ; value of the previous item at the same weight
                      ((v (- d 1)) w)
                      ; (value of previous item at (current weight - weight of this item))
                      ; + value of this item
                      (+
                        ((v (- d 1)) (- w ((items (- d 1)) 1)))
		                    ((items (- d 1)) 2))))) 
                (inc w))
              ; make the our transient vector persistent before passing it to the outer loop
		          (persistent! u))))
        (inc d))      
      (persistent! v))))

(comment "Makes sense of table from 'make-dynamic-table'.")
(defn find-optimum 
  [table items weight]
  (loop [_weight weight cnt (count items) results (transient [])]
    (if (> cnt 0)
      ; If the value at the current weight and item != the value at the previous item and same weight
      ; then we know a value was added here, so we add this to our result set and subtract the item's weight.
      ; Otherwise, we only decrement our count and continue.
      (let [add (not=
                  (get (get table cnt) _weight)
                  (get (get table (- cnt 1)) _weight))]
		    (recur 
	        (if add
			      (- _weight ((items (- cnt 1)) 1))
	          _weight)
	        (dec cnt)
	        (if add
	          (conj! results (items (- cnt 1)))
	          results)))
      (persistent! results))))

(comment "Prints the input and output in the format shown in the original repo.")
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
    (println)))

(defn knapsack [items weight]
   (find-optimum (make-dynamic-table items weight) items weight))

(defn -main
  "A solution to https://github.com/micahalles/doll-smuggler"
  [& args]
  (println)
  (println "    *** Doll Smuggler ***")
  (println)
  (pretty-print
    '("max weight: 400" "available dolls:")
    '("name" "weight" "value")
    dolls)
  (pretty-print 
    '("packed dolls:")
    '("name" "weight" "value")
    (knapsack dolls max-weight)))
