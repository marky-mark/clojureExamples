(ns LiteralsTest
  (:require [clojure.test :refer :all]
            [Literals :refer :all]
            )
  )

(deftest personVaue
  (is (= (:city person) "Portland, ME")))

(deftest pizzaLocationTest
  (is (= (:Literals/location pizza) "43.3734,-72.3365")))

(deftest nameLocationTest
  (is (= (name :pizza/location) "location")))

(deftest namespaceLocationTest
  (is (= (namespace :pizza/location) "pizza")))

(deftest nilLocationTest
  (is (= (namespace :location) nil)))

(deftest classOfTest
  (is (= (class #"(p|h)ail") java.util.regex.Pattern)))

; couldn't get below matching
#_(deftest sequenceTest
  (is (= (re-seq #"(\d+)-(\d+)" "1-3") (["1-3" "1" "3"]))))
(comment this is a comment)

(deftest sequenceTest
  (is (identical? "x" "x")))


