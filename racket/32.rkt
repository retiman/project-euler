(require "lib/core.rkt")

(define pandigital-products (make-hash))

(define (number->list n)
  (string->list (number->string n)))

(define (list->number lst)
  (string->number (list->string lst)))

(define (list->number* lst)
  (string->number (apply string-append (map number->string lst))))

(define (pandigital-product-values n i j)
  (let*-values (((lst) (number->list n))
                ((a rst) (split-at lst i))
                ((b c) (split-at rst j))
                ((a*) (list->number a))
                ((b*) (list->number b))
                ((c*) (list->number c)))
    (list a* b* c*)))

(define (check-pandigital-product a b c)
  (let ((p1 (list->number* (list a b c)))
        (p2 (list->number* (list b a c))))
    (when (and (not (hash-has-key? pandigital-products p1))
               (= c (* a b)))
      (hash-set! pandigital-products p1 c)
      (hash-set! pandigital-products p2 c))))

(begin
  (for ((p (permutations (range 1 10))))
    (let ((n (list->number* p)))
      (apply check-pandigital-product (pandigital-product-values n 2 3))
      (apply check-pandigital-product (pandigital-product-values n 1 4))))
  (displayln
    (for/sum ((i (distinct (hash-values pandigital-products))))
      i)))
