#lang racket
(require rackunit)
(require srfi/1)
(require "lib/core.rkt")


(define names
  ((compose (curry regexp-split ",")
            (curryr string-replace "\"" ""))
    (file->string "/data/22.txt")))

(define scores
  (zipmap (map integer->char (range (char->integer #\A)
                                    (add1 (char->integer #\Z))))
          (range 1 (add1 26))))

(define (score s)
  (for/sum ((c (string->list s)))
    (hash-ref scores c)))

(define m
  (zipmap (range 1 (add1 (length names)))
          (map (curry score) (sort names string<?))))

(define result
  (for/sum ((k (hash-keys m)))
    (* k (hash-ref m k))))

(displayln result)
(check-equal? result 871198282)
