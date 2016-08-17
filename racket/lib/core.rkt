#lang racket

(provide char->integer*
         char-list->integer
         define-memo
         distinct
         hash-merge
         hash-merge!
         integer->char-list
         integer->list*
         list->integer*
         memoize
         set-filter
         set-length
         zip
         zipmap)

; Converts a char to the integer it maps to. Contrast with core library's
; char->integer which returns the character's code point. For example:
;
;   (= (char->integer #\1) 49)
;   (= (char->integer* #\1) 1)
(define (char->integer* c)
  (string->number (make-string 1 c)))

; Define an alias for remove-duplicates.
(define distinct remove-duplicates)

; Returns a hash with the 2 immutable hashes merged, with duplicate keys from b
; overriding keys from a.
(define (hash-merge a b)
  (define (loop h ks)
    (if (empty? ks)
      h
      (let* ((k (first ks))
             (v (hash-ref b k)))
        (loop (hash-set h k v) (rest ks)))))
  (loop a (hash-keys b)))

; Merges 2 mutable hashes together, with duplicate keys being overridden.
; Hash a will contain the keys from hash b.
(define (hash-merge! a b)
  (for ((k (hash-keys b)))
    (hash-set! a k (hash-ref b k))))

; Converts an integer to a list of chars. For example,
; (= (integer->char-list 123) '(#\1 #\2 #\3))
(define (integer->char-list n)
  (string->list (number->string n)))

; Converts an integer to a list of integers. For example,
; (= (integer->list* 123) '(1 2 3))
(define (integer->list* n)
  (map char->integer* (integer->char-list n)))

; Converts a list of chars to an integer. For example,
; (= '(#\1 #\2 #\3) (integer->char-list 123))
(define (char-list->integer lst)
  (string->number (list->string lst)))

; Converts a list of integers to an integer. For example,
; (= '(1 2 3) (integer->list 123))
(define (list->integer* lst)
  (string->number (apply string-append (map number->string lst))))

(define (set-filter pred? s)
  (for/set ((e s) #:when (pred? e)) e))

(define (set-length s)
  (sequence-length s))

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

; Returns a hash with the keys as the first list and the values as the second
; list.
(define (zipmap . args)
  (apply hash (flatten (apply zip args))))

(define-syntax-rule (define-memo (id . p) . body)
  (define id (memoize (λ p . body))))
