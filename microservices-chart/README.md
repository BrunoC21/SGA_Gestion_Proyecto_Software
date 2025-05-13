# Microservices Helm Chart

Este chart despliega los siguientes componentes en un clúster de Kubernetes:

- microservice-config
- microservice-eureka
- microservice-gateway
- microservice-inventory
- PostgreSQL (para `microservice-inventory`)

## 🚀 Requisitos

- [Helm 3](https://helm.sh/docs/intro/install/)
- [Minikube](https://minikube.sigs.k8s.io/)
- `kubectl` configurado

## 🛠️ Instalación en Minikube

1. Clona o descarga este repositorio:

```bash
git clone <este-repositorio> # o descomprime el ZIP
cd microservices-chart
```

2. Inicia Minikube si no está activo:

```bash
minikube start
```

3. Instala el chart con Helm:

```bash
helm install microservices-chart .
```

4. Verifica los pods y servicios:

```bash
kubectl get pods
kubectl get svc
```

## 🌐 Acceso externo

Para acceder a `microservice-gateway` desde el navegador, obtén el puerto asignado por Minikube:

```bash
minikube service gateway --url
```

## 📦 Desinstalar

```bash
helm uninstall microservices-chart
```

---

📌 Asegúrate de que el servicio de `config` esté completamente disponible antes de los demás para evitar errores de configuración al arrancar los otros microservicios.
