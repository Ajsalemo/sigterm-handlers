FROM python:3.14.3-slim-bookworm

WORKDIR /app/
COPY requirements.txt /app/
RUN pip install -r requirements.txt

COPY . .

EXPOSE 8000

ENTRYPOINT [ "gunicorn", "-b", "0.0.0.0:8000", "app:app", "--timeout", "600", "--access-logfile", "-", "--error-logfile", "-" ]