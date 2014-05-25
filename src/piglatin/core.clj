(ns piglatin.core
  (:require [clojure.string :refer [split]]))

(def wovels (set "aouåeiyäö"))
(def pig-latin-postfix "ay")

(defn alpha? [c]
  (re-matches #"[a-öA-Ö]" (str c)))

(defn wovel? [c]
  (wovels c))

(defn consonant? [c]
  (and (not (wovel? c)) (alpha? c)))

(defn split-to-words [s]
  (filter not-empty (split s #" +")))

(defn pig-latin-word [s]
  (let [[leading-cons rest] (split-with consonant? s)]
    (apply str (flatten [rest leading-cons pig-latin-postfix]))))

(defn pig-latin [s]
  (let [words (split-to-words s)
        words-in-pig-latin (map pig-latin-word words)]
    (apply str (interpose " " words-in-pig-latin))))
