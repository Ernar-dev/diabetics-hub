dev:
	docker compose -f docker-compose.yml up --build
prod:
	docker compose -f docker-compose.yml up --build -d
