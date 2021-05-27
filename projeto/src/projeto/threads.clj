(ns projeto.threads
  (:require [projeto.core :as core]))

(defn add-transaction

  [transactions-world new-transaction]
  (conj transactions-world new-transaction))

(defn main
  [transactions-world]
  (->>
   (core/create-transactions "venda" 403.45)
   (add-transaction transactions-world )
   (core/calcula-valor)))