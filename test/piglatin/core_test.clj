(ns piglatin.core-test
  (:require [clojure.test :refer :all]
            [piglatin.core :refer :all]))

(deftest is-wovel-test
  (testing "Test if character is wovel"
    (is (is-wovel \a))
    (is (not (is-wovel \b)))))

(deftest is-alpha-test
  (is (is-alpha \a))
  (is (not (is-alpha \#))))

(deftest starts-with-wovel-test
  (testing "Test if word starts with wovel"
    (is (starts-with-wovel "apa"))
    (is (not (starts-with-wovel "banan")))
    (is (not (starts-with-wovel "")))
    (is (not (starts-with-wovel "---")))))

(deftest starts-with-consonant-test
  (is (starts-with-consonant "bapelsin"))
  (is (not (starts-with-consonant "apelsin")))
  (is (not (starts-with-consonant "")))
  (is (not (starts-with-consonant "/citron"))))
