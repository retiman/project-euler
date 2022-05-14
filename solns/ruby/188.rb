def order(a, m)
  b = a % m
  e = 1
  while b != 1
    b = (a * b) % m
    e += 1
  end
  e
end

def mexp(a, e, m)
  r = 1
  b = a
  k = e
  while k.positive?
    r = (r * b) % m if k & 1 == 1
    k >>= 1
    b = (b * b) % m
    return 0 if b.zero?
    return r if b == 1
  end
  r
end

def mtet(a, t, m)
  return 0 if m == 1
  return a % m if t == 1

  ord = order(a, m)
  e = mtet(a, t - 1, ord)
  mexp(a, e, m)
end

result = mtet(1777, 1855, 100_000_000)

puts result
raise Error unless result == 95_962_097
