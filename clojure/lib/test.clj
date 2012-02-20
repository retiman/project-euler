(load-file "core.clj")
(use '[clojure.test])

(defn pow [n e]
  (bigint (Math/pow n e)))

(deftest test-fact
  (is (= 1 (fact 0)))
  (is (= 1 (fact 1)))
  (is (= 2 (fact 2)))
  (is (= 6 (fact 3)))
  (is (= 24 (fact 4)))
  (is (= 120 (fact 5))))

(deftest test-permute
  (is (= 6 (permute 3 2)))
  (is (= 1 (permute 5 0)))
  (is (= 5 (permute 5 1)))
  (is (= 20 (permute 5 2)))
  (is (= 60 (permute 5 3)))
  (is (= 120 (permute 5 4)))
  (is (= 120 (permute 5 5))))

(deftest test-choose
  (is (= 1 (choose 3 0)))
  (is (= 3 (choose 3 1)))
  (is (= 3 (choose 3 2)))
  (is (= 1 (choose 3 3)))
  (is (= 0 (choose 3 4))))

(deftest test-totient
  (is (= 0 (totient 1)))
  (is (= 1 (totient 2)))
  (is (= 2 (totient 3)))
  (is (= 6 (totient 9)))
  (is (= 256 (totient 512)))
  (is (= 82260072 (totient 123456789))))

(deftest test-divisors
  (is (= #{1} (divisors 1)))
  (is (= #{1 2} (divisors 2)))
  (is (= #{1 3 9} (divisors 9)))
  (is (= #{1 2 3 4 6 8 9 12 18 24 36 72 601 1202 1803 1901 2404 3606 3802 4808
           5409 5703 7212 7604 10818 11406 14424 15208 17109 21636 22812 34218
           43272 45624 68436 136872 1142501 2285002 3427503 4570004 6855006
           9140008 10282509 13710012 20565018 27420024 41130036 82260072}
         (divisors 82260072))))

(deftest test-mod-tet
  (is (= 2 (mod-tet 2 1 3)))
  (is (= 1 (mod-tet 2 2 3)))
  (is (= 1 (mod-tet 2 3 3)))
  (is (= 1 (mod-tet 2 4 3)))
  (is (= 0 (mod-tet 15 4 27)))
  (is (= 1777 (mod-tet 1777 1 (pow 10 8))))
  (is (= 87955697 (mod-tet 1777 2 (pow 10 8))))
  (is (= 99034097 (mod-tet 1777 3 (pow 10 8))))
  (is (= 95962097 (mod-tet 1777 1855 (pow 10 8))))
  (is (= (mod-pow 15 1 57) (mod-tet 15 1 57)))
  (is (= (mod-pow 15 15 57) (mod-tet 15 2 57)))
  (is (= 18 (mod-tet 15 3 57)))
  (is (= (mod-pow 3 27 15) (mod-tet 3 2 15)))
  (is (= (mod-pow 3 7625597484987 15) (mod-tet 3 3 15)))
  (is (= (mod-pow 3 27 123456789) (mod-tet 3 3 123456789))))

(deftest test-order
  (is (= 2 (order 2 3)))
  (is (= 1 (order 3 2)))
  (is (= 2 (order 6 7))))

(run-tests)
