(require "lib/core.rkt")

(define pandigital-products (make-hash))

(define (pandigital-product-values n i j)
  (let*-values (((lst) (integer->char-list n))
                ((a rst) (split-at lst i))
                ((b c) (split-at rst j))
                ((a*) (list->integer a))
                ((b*) (list->integer b))
                ((c*) (list->integer c)))
    (list a* b* c*)))

(define (check-pandigital-product a b c)
  ; If abc forms a pandigital product, then bac forms one as well.
  (let ((p1 (list->integer* (list a b c)))
        (p2 (list->integer* (list b a c))))
    (when (and (not (hash-has-key? pandigital-products p1))
               (= c (* a b)))
      (hash-set! pandigital-products p1 c)
      (hash-set! pandigital-products p2 c))))

(begin
  (for ((p (permutations (range 1 10))))
    (let ((n (list->integer* p)))
      ; Check for products formed by a * bcde = fghi or abcd * e = fghi.
      (apply check-pandigital-product (pandigital-product-values n 1 4))
      ; Check for products formed by ab * cde = fghi or abc * de = fghi.
      ; It's impossible to have a product with 5 digits because:
      ; (* 9 876) and (* 98 76) don't have 5 digits, but those are the max
      ; products you can get with the 4 remaining digits.
      (apply check-pandigital-product (pandigital-product-values n 2 3))))
  (displayln
    (for/sum ((i (distinct (hash-values pandigital-products))))
      i)))
