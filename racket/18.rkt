(require math/matrix)

(define input
  "75
  95 64
  17 47 82
  18 35 87 10
  20 04 82 47 65
  19 01 23 75 03 34
  88 02 77 73 07 63 67
  99 65 04 28 06 16 70 92
  41 41 26 56 83 40 80 70 33
  41 48 72 33 47 32 37 16 94 29
  53 71 44 65 25 43 91 52 97 51 14
  70 11 33 28 77 73 17 78 39 68 17 57
  91 71 52 38 17 14 91 43 58 50 27 29 48
  63 66 04 68 89 53 67 30 73 16 69 87 40 31
  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23")

(define (string->row s)
  (map string->number (regexp-split #px" " s)))

(define data
  ((compose
     list->vector
     (curry map list->vector)
     (curry map string->row)
     (curry map string-trim)
     (curry regexp-split #px"\n"))
  input))

(define (data-ref . args)
  (let* ((data (list-ref args 0))
         (i (list-ref args 1))
         (j (if (= (length args) 3) (list-ref args 2) +nan.0)))
    (if (nan? j)
      (vector-ref data i)
      (vector-ref (vector-ref data i) j))))

(define (data-length . args)
  (let* ((data (list-ref args 0))
         (i (if (= (length args) 2) (list-ref args 1) +nan.0)))
    (if (nan? i)
      (vector-length data)
      (vector-length (data-ref data i)))))

(define (data-set data i j value)
  (vector-set! (vector-ref data i) j value))

(for* ((i (range (- (data-length data) 2) (sub1 0) -1))
       (j (range 0 (data-length data i))))
  (let* ((current (data-ref data i j))
         (left (data-ref data (add1 i) j))
         (right (data-ref data (add1 i) (add1 j)))
         (bigger (max left right)))
    (data-set data i j (+ current bigger))))

(displayln (data-ref 0 0))
