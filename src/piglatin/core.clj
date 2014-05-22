(ns piglatin.core)

(def wovels (set "aou�eiy��"))

(defn is-wovel [c]
  (wovels c))

(defn starts-with-wovel [s]
  (is-wovel (first s)))

(defn is-alpha [c]
  (re-matches #"[a-�A-�]" (str c)))

(defn starts-with-consonant [s]
  (let [c (first s)] 
    (and (is-alpha c) (not (is-wovel c)))))


