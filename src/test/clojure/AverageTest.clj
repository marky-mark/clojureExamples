(ns AverageTest
  (:require [clojure.test :refer :all ]
            [Average :refer :all ]
            )
  )

(with-test
  (defn my-function [x y]
    (+ x y))
  (is (= 4 (my-function 2 2)))
  (is (= 7 (my-function 3 4))))

(deftest addition
         (is (= 4 (+ 2 2)))
         (is (= 7 (+ 3 4))))

(deftest averageTest
  (is (= 5  (average [5,5]))))





