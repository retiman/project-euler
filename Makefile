.PHONY: %

%:
	poetry run pytest project_euler/$@.py
