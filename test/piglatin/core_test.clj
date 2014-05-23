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

(deftest test-first-elem-test
  (is (test-first-elem odd? [1 2 3]))
  (is (test-first-elem (partial = \a) "abc")))

(deftest starts-with-wovel?-test
  (testing "Test if word starts with wovel"
    (is (starts-with-wovel? "apa"))
    (is (not (starts-with-wovel? "banan")))
    (is (not (starts-with-wovel? "")))
    (is (not (starts-with-wovel? "---")))))

(deftest starts-with-consonant?-test
  (is (starts-with-consonant? "bapelsin"))
  (is (not (starts-with-consonant? "apelsin")))
  (is (not (starts-with-consonant? "")))
  (is (not (starts-with-consonant? "/citron"))))

(deftest split-to-words-test
  (is (empty? (split-to-words "")))
  (is (= ["apan"] (split-to-words "apan")))
  (is (= ["knatte" "fnatte" "tjatte"] (split-to-words "knatte fnatte tjatte")))
  (is (= ["a" "b" "c"] (split-to-words "  a  b  c  "))))

(deftest apply-wovel-rule-test
  (is (thrown? AssertionError (apply-wovel-rule "banan")))
  (is (= "away" (apply-wovel-rule "a"))))
