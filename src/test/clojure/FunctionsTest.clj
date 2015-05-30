 (ns FunctionsTest
  (:require [clojure.test :refer :all ]
            [Functions :refer :all ]
            ))

 (deftest strange-adder-test
  (is (= (strange-adder 10) 11)))

(deftest strange-adder-more-test
 (is (= (strange-adder 10 3) 13)))

(deftest concat-rest-test
 (is (= (concat-rest 0 1 2 3 4) "123")))

 (deftest random-user-test
  (let [{user-id :user-id} (make-user)]
   (println "Random uuid is " user-id)))

(deftest random-user-2-test
 (let [{user-id :user-id} (make-user "Foo")]
  (is (= user-id "Foo"))))

 (deftest random-full-user-test
  (let [foo (make-full-user "Bobby")]
   (println "Full user " foo))
  )

(deftest random-fuller-user-test
 (let [foo (make-full-user "Bobby" :join-date (java.util.Date. 111 0 1)
                      :email "bobby@example.com")]
  (println "Fuller user " foo))
 )
