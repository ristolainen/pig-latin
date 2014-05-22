(ns piglatin.core)

(def wovels (set "aouåeiyäö"))

(defn is-wovel [c]
  (wovels c))

(defn starts-with-wovel [s]
  (is-wovel (first s)))

(defn is-alpha [c]
  (re-matches #"[a-öA-Ö]" (str c)))

(defn starts-with-consonant [s]
  (let [c (first s)] 
    (and (is-alpha c) (not (is-wovel c)))))


