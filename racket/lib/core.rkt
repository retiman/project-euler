#lang racket

(provide char->integer*
         define/memo
         memoize
         set-length
         stream-drop
         stream-dropf
         stream-take
         stream-takef
         zip
         zipmap)

(define (char->integer* c)
  (string->number (make-string 1 c)))

(define (hash-merge! a b)
  (for ((k (hash-keys b)))
    (hash-set! a k (hash-ref b k))))

(define (hash-merge a b)
  (define (loop h ks)
    (if (empty? ks)
      h
      (let* ((k (first ks))
             (v (hash-ref b k)))
        (loop (hash-set h k v) (rest ks)))))
  (loop a (hash-keys b)))

(define (set-length s)
  (sequence-length s))

(define (stream-drop s n)
  (if (= n 0) s (stream-drop (stream-rest s) (sub1 n))))

(define (stream-dropf s pred)
  (if (not (pred (stream-first s)))
    s
    (stream-dropf (stream-rest s) pred)))

(define (stream-take s n)
  (for/list ((e s) (i (in-range n))) e))

(define (stream-takef s pred)
  (for/list ((e s) #:break (not (pred e))) e))

(define (memoize f)
  (define h (make-hash))
  (λ args
    (hash-ref h args (λ ()
                       (hash-set! h args (apply f args))
                       (hash-ref h args)))))

(define (zip xs ys . lists)
  (for ((l (list* xs ys lists)))
    (unless (list? l) (raise-argument-error 'zip "list?" l)))
  (apply map list (list* xs ys lists)))

(define (zipmap . args)
  (apply hash (flatten (apply zip args))))

(define-syntax-rule (define/memo (id . p) . body)
  (define id (memoize (λ p . body))))
