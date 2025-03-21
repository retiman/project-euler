import subprocess


def run_cmd(cmd):
    subprocess.run(cmd, shell=True, check=True)


def run_all():
    run_format()
    run_lint()
    run_tests()


def run_lint():
    run_cmd("poetry run ruff check --fix solns")
    run_cmd("poetry run pyright solns")


def run_format():
    run_cmd("poetry run black solns")
    run_cmd("poetry run isort solns")


def run_tests():
    run_cmd("poetry run pytest solns")
