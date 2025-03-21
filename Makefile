.PHONY: %

%:
	poetry run pytest solns/$@.py
