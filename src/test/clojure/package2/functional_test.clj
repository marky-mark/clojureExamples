(ns package2.functional-test
  (:require [clojure.test :refer :all]
            [chapter2.functional :refer :all]
            [clojure.string :as str]
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

(deftest apply-test
  (is (= (apply hash-map [:a 5 :b 6]) {:a 5, :b 6})))

(def only-strings (partial filter string?))

(deftest only-strings-test
  (is (= (only-strings ["a" 5 "b" 6]) ["a" "b"])))

(deftest filter-string-test
  (is (= (#(filter string? %) ["a" 5 "b" 6]) ["a" "b"])))

(deftest filter-string-2-test
  (is (= (#(filter % ["a" 5 "b" 6]) string?) ["a" "b"])))

(deftest filter-number
  (is (= (#(filter % ["a" 5 "b" 6]) number?) [5 6])))

(comment function literals force you to fully specify all of the arguments to
         the functions it calls, whereas partial allows you to be ignorant of such details)

(comment the same as
         (defn negated-sum-str
           [& numbers]
           (str (- (apply + numbers))))

         comp is composition)
(def negated-sum-str (comp str - +))

(deftest negated-sum-str-test
  (is (= (negated-sum-str 10 12 3.4) "-25.4")))

(def camel->keyword (comp keyword
                          str/join
                          (partial interpose \-)
                          (partial map str/lower-case)
                          #(str/split % #"(?<=[a-z])(?=[A-Z])")))

(deftest camel->keyword->test->foo->hey
  (is (= (camel->keyword "CamelCase") ':camel-case)))







