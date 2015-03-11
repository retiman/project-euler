#lang racket

(provide define/memo
         char->number
         memoize
         set-length
         stream-take
         stream-takef)

(define (char->number c)
  (string->number (make-string 1 c)))

(define (hash-merge! a b)
  (for ((k (hash-keys b)))
    (hash-set! a k (hash-ref b k))))

(define (hash-merge a b)
  (define (hash-merge* h ks)
    (if (empty? ks)
      h
      (let* ((k (first ks))
             (v (hash-ref b k)))
        (hash-merge* (hash-set h k v) (rest ks)))))
  (hash-merge* a (hash-keys b)))

(define (set-length s)
  (sequence-length s))

(define (stream-take s n)
  (for/list ((e s) (i (in-range n))) e))

(define (stream-takef s f)
  (for/list ((e s) #:break (not (f e))) e))

(define (memoize f)
  (define h (make-hash))
  (λ args
    (hash-ref h args (λ ()
                       (hash-set! h args (apply f args))
                       (hash-ref h args)))))

(define-syntax-rule (define/memo (id . p) . body)
  (define id (memoize (λ p . body))))
