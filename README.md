# doll-smuggler
##Clojure Programming Challenge

###How To Run this:

- Have [leiningen](https://github.com/technomancy/leiningen) and [Clojure](clojure.org)
- `clone` this repository
- At a terminal prompt
  - `cd` to `[path/to/clone]/smugdoll`
  - Run main with `lein run -m co.mlangdon.smugdoll`
    - Expected output:
```
    *** Doll Smuggler ***

    max weight: 400

    available dolls:

    name     weight value
    luke        9   150
    anthony    13    35
    candice   153   200
    dorothy    50   160
    puppy      15    60
    thomas     68    45
    randal     27    60
    april      39    40
    nancy      23    30
    bonnie     52    10
    marc       11    70
    kate       32    30
    tbone      24    15
    granny     48    10
    uma        73    40
    grumpkin   42    70
    dusty      43    75
    grumpy     22    80
    eddie       7    20
    tory       18    12
    sally       4    50
    babe       30    10

    packed dolls:

    name     weight value
    sally       4    50
    eddie       7    20
    grumpy     22    80
    dusty      43    75
    grumpkin   42    70
    marc       11    70
    randal     27    60
    puppy      15    60
    dorothy    50   160
    candice   153   200
    anthony    13    35
    luke        9   150
```    
  - Run tests with `lein test co.mlangdon.smugdoll-test`
    - Expected output:
```
    lein test co.mlangdon.smugdoll-test

    Ran 2 tests containing 2 assertions.
    0 failures, 0 errors.
```    
