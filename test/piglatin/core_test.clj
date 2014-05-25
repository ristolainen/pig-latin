(ns piglatin.core-test
  (:require [clojure.test :refer :all]
            [piglatin.core :refer :all]))

(deftest wovel?-test
  (testing "Test if character is wovel"
    (is (wovel? \a))
    (is (not (wovel? \b)))
    (is (not (wovel? \-)))))

(deftest consonant?-test
  (is (consonant? \b))
  (is (not (consonant? \a)))
  (is (not (consonant? \#))))

(deftest alpha?-test
  (is (alpha? \a))
  (is (not (alpha? \#))))

(deftest split-to-words-test
  (is (empty? (split-to-words "")))
  (is (= ["apan"] (split-to-words "apan")))
  (is (= ["knatte" "fnatte" "tjatte"] (split-to-words "knatte fnatte tjatte")))
  (is (= ["a" "b" "c"] (split-to-words "  a  b  c  "))))

(deftest pig-latin-word-test
  (is (= "abay" (pig-latin-word "ba")))
  (is (= "aay" (pig-latin-word "a")))
  (is (= "cay" (pig-latin-word "c")))
  (is (= "abcay" (pig-latin-word "abc")))
  (is (= "igpay" (pig-latin-word "pig")))
  (is (= "apeay" (pig-latin-word "ape"))))

(deftest pig-latin-test
  (is (= "isnodebay attarfay artasmay eslutbay" 
         (pig-latin "bisnode fattar smarta beslut"))))
