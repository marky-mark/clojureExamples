 (ns SpecialFormTest
   (:require [clojure.test :refer :all]
             [SpecialForm :refer [hypot v foo fooAgain fooMore fooRest retain
                                  mapDestruct mapFoo, mapFoo2, map2D, mapDestructAgain
                                  seqMap, resolveBirthday]
              ]
             )
   )

 (deftest suppressionOfEvalution
   (is (= (list? '(+ x x)) true)))

(do
  (println "hi")
  (println (apply * [4 5 6])) )

;let local bindings
(let [a (inc (rand-int 6))
      b (inc (rand-int 6))]
  ;let allows a 'do' here!
  (println (format "You rolled a %s and a %s" a b))
  (+ a b))

 (deftest hypotTest
   (is (= (hypot 2 3) 3.605551275463989)))

 (deftest accessVariables
   (is (= (first v) 42))
   (is (= (second v) "foo"))
   (is (= (last v) [5 12]))
   (is (= (v 2) 99.2))
   ;All of Clojure’s sequential collections implement the java.util.List interface
   (is (= (.get v 2) 99.2))
   (is (= (nth v 2) 99.2))
   #_(is (= ((+ (first v) (v 2))) 141.2))
   #_(is (= (+ (first v) (first (last v))) 47))
   )

 (deftest fooTest
   (is (= foo 141.2)))

(deftest fooAgainTest
  (is (= fooAgain 141.2)))

(deftest fooMoreTest
  (is (= fooMore 59)))

(deftest fooRestTest
  (is (= fooRest '("foo" 99.2 [5 12]))))

(deftest retainTest
  (is (= retain '[42 "foo" 99.2 [5 12] 141.2])))

(deftest mapDestructTest
  (is (= mapDestruct 11)))

(deftest mapFooTest
  (is (= mapFoo 100)))

(deftest mapFoo2Test
  (is (= mapFoo2 0)))

(deftest map2DTest
  (is (= map2D -17)))

(deftest mapDestructAgainTest
  (is (= mapDestructAgain 20)))

 (deftest seqMapTest
   (is (= seqMap 16)))

 (deftest resolveBirthdayTest
   (is (= resolveBirthday "James was born on Tue Feb 06 00:00:00 GMT 1973")))


