(ns piglatin.core
  (:require [clojure.string :refer [split]]))

(def wovels (set "aouåeiyäö"))
(def wovel-rule-ending "way")

(defn alpha? [c]
  (re-matches #"[a-öA-Ö]" (str c)))

(defn wovel? [c]
  (wovels c))

(defn consonant? [c]
  (and (not (wovel? c)) (alpha? c)))

(defn test-first-elem [pred s]
  (pred (first s)))

(def starts-with-wovel? (partial test-first-elem wovel?))

(def starts-with-consonant? (partial test-first-elem consonant?))

(defn split-to-words [s]
  (filter not-empty (split s #" +")))

(defn apply-wovel-rule [s]
  {:pre [(starts-with-wovel? s)]}
  (str s wovel-rule-ending))
