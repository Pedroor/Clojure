(ns projeto.core
  (:gen-class))
(defn create-transactions
  [nome valor]
  {:nome nome :valor valor})

(def transactions
  [(create-transactions "venda" 12.99)
   (create-transactions "venda" 123.45)
   (create-transactions "compra" -100)
   (create-transactions "compra" -1.99)])
(defn get-valores-a
  [transactions-world]
  (map :valor transactions-world))

(defn get-valores-b
  [transactions-world]
  (map (fn [x] (:valor x)) transactions-world))

(defn get-valores-c
  [transactions-world]
  (map #(:valor %) transactions-world))

(defn calcula-valor
  [transactions-world]
  (reduce + (get-valores-a transactions-world)))

(defn isVenda?
  [transactions-world]
  (= "venda" (:nome transactions-world)))
(defn get-vendas
  [transactions-world]
  (filter isVenda? transactions-world))

(def apresentacao "Meu nome é Pedro")
(def apresentacao-bom-dia(format "Bom dia! %s" apresentacao))

(def atoms [:p, :q, :r , :s , :t , :u])

(defn transform [person]
   (update (assoc person :hair-color :gray) :age inc))

(defn transform* [person]
   (-> person
      (assoc :hair-color :gray)
      (update :age inc)))

(defn calculate []
   (reduce + (map #(* % %) (filter odd? (range 10)))))

(defn calculate* []
   (-> (range 10)
        (filter odd? ,,,)
        (map #(* % %) ,,,)
        (reduce + ,,,)))

(defn -main
  [& args]
  (println "Hello, World!"))
