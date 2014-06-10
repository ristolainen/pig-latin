(ns piglatin2.core)

(def wovels (set "aouåeiyäö"))

(def pl-postfix "ay")

(defn wovel? [c]
  (wovels c))

(defn alpha? [c]
  (re-matches #"[a-öA-Ö]" (str c)))

(defn consonant? [c]
  (and (not (wovel? c)) (alpha? c)))

(defn upper-case? [c]
  (Character/isUpperCase c))

(defn upper-case [c uc]
  (if uc (Character/toUpperCase c) c))

(defn preserve-case [o n]
  (let [cp (map upper-case? o)]
    (apply str (map upper-case n cp))))

(defn pig-latin-word [s]
  (let [[consonants rest] (split-with consonant? (.toLowerCase s))
        [alphas non-alphas] (split-with alpha? rest)
        base (preserve-case s (concat alphas consonants))]
    (apply str (concat base pl-postfix non-alphas))))

(defn split-to-words [s]
  (seq (.split (.trim s) "\\s+")))

(defn pig-latin
  "Translates a sentance to pig latin."
  [s]
  (let [words (split-to-words s)
        words-in-pl (map pig-latin-word words)]
    (apply str (interpose \space words-in-pl))))


