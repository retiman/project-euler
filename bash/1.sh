# 233168
# 0.08user 0.00system 0:00.09elapsed 93%CPU (0avgtext+0avgdata 0maxresident)k
# 0inputs+0outputs (0major+747minor)pagefaults 0swaps

sum=0
for i in $(seq 1 999); do
  if [ $((i % 3)) -eq 0 ]; then
    sum=$((sum + i))
  elif [ $((i % 5)) -eq 0 ]; then
    sum=$((sum + i))
  fi
done

echo $sum
