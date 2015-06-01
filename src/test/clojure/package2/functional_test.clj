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

