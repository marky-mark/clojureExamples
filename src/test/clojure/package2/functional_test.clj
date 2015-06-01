(ns package2.functional-test
  (:require [clojure.test :refer :all]
            [chapter2.functional :refer :all]
            ))

;HOF - Higher Order Functions (Take functions as arguments or return a function as result)
(deftest call-twice-test
  (call-twice println 123))

(deftest max-test
  (is (= (max 5 6) 6)))

(deftest lowercase-test
  (is (= (clojure.string/lower-case "Clojure") "clojure")))

(deftest map-test
  (is (= (map clojure.string/lower-case ["Java" "Imperative" "Weeping"
                                         "Clojure" "Learning" "Peace"])
         '("java" "imperative" "weeping" "clojure" "learning" "peace"))))

(deftest map-double-vector-test
  (is (= (map * [1 2 3 4] [5 6 7 8]) '(5 12 21 32))))

(comment similar to doing (max (max (max 0 -3) 10) 48) manually)
(deftest reduce-test
  (is (= (reduce max [0 -3 10 48]) 48)))

(deftest reduce-add-test
  (is (= (reduce + 50 [1 2 3 4]) 60)))

(comment #() can reduce the anonymous function fn. See next example)
(deftest reduce-collection-to-map-test
  (is (= (reduce
           (fn [m v]
             (assoc m v (* v v)))
           {} [1 2 3 4]) {4 16, 3 9, 2 4, 1 1}))
  )

(deftest reduce-collection-to-map-better-test
  (is (= (reduce
           #(assoc % %2 (* %2 %2))
           {}
           [1 2 3 4]) '{4 16, 3 9, 2 4, 1 1}))
  )






