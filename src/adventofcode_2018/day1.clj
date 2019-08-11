(ns adventofcode-2018.day1
  (:require [clojure.string :as str]))

(def data
  (->> (str/split (slurp "resources/day1.txt") #"\n")
       (map read-string)))

;; Part 1
(apply + data)

;; Part 2
(defn occured-twice [md]
  (letfn [(ot [mdi, sums, last-sum]
            (if (empty? mdi)
              (ot md sums last-sum)
              (let [sum (+ (first mdi) last-sum)]
                (if (contains? sums sum)
                  sum
                  (recur (rest mdi) (conj sums sum) sum)))))]
    (ot md #{0} 0)))

(and
 (= (occured-twice [1, -1]) 0)
 (= (occured-twice [3, 3, 4, -2, -4]) 10)
 (= (occured-twice [-6, 3, 8, 5, -6]) 5)
 (= (occured-twice [7, 7, -2, -7, -4]) 14))

(occured-twice data)