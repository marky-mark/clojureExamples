(ns package2.stateful-integer-test
  (:require [clojure.test :refer :all]
            [chapter2.stateful-integer :refer :all]
            )
  (:import (chapter2 StatefulInteger)))

(deftest printIntValueTest
  (print-number six))

;Sadly the below is true..not false. due to mutability?
;(deftest assertStatefulInteger
;  (is (= six five)))
;
;(deftest assertNotStatefulInteger
;  (is (= (StatefulInteger. 42) five)))
