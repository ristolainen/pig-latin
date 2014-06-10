(ns piglatin2.core-test
  (:require [clojure.test :refer :all]
            [piglatin2.core :refer :all]))

(deftest wovel-test?
  (is (wovel? \a))
  (is (not (wovel? \b)))
  (is (not (wovel? \-))))

(deftest consonant-test?
  (is (consonant? \x))
  (is (not (consonant? \y)))
  (is (not (consonant? \!))))

(deftest alpha-test?
  (is (alpha? \a))
  (is (not (alpha? \1))))

(deftest pig-latin-word-test
  (is (= "aay" (pig-latin-word "a")))
  (is (= "bay" (pig-latin-word "b")))
  (is (= "acay" (pig-latin-word "ca")))
  (is (= "igpay" (pig-latin-word "pig")))
  (is (= "eslutbay!" (pig-latin-word "beslut!")))
  (is (= "Isnodebay" (pig-latin-word "Bisnode"))))

(deftest split-to-words-test
  (is (= '("a") (split-to-words "a")))
  (is (= '("apa" "banan") (split-to-words "apa banan")))
  (is (= '("apa" "banan" "citron") (split-to-words "  apa   banan   citron  "))))

(deftest pig-latin-test
  (is (= "yxay" (pig-latin "xy")))
  (is (= "apaay ananbay" (pig-latin "apa banan"))))
