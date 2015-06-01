(ns package2.functional-test
  (:require [clojure.test :refer :all]
            [chapter2.functional :refer :all]
            ))

;HOF - Higher Order Functions (Take functions as arguments or return a function as result)
(deftest call-twice-test
  (call-twice println 123) )

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


