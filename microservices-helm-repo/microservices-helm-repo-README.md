
# Microservices Helm Repo with Argo CD (App of Apps)

Este repositorio contiene una estructura completa para desplegar un sistema de microservicios basado en Spring Boot, usando:

- Helm para empaquetar servicios
- Argo CD como Continuous Delivery (CD)
- Spring Cloud Config como servidor de configuración centralizada
- Eureka para descubrimiento de servicios
- Gateway para enrutar peticiones
- PostgreSQL como base de datos
- GitOps mediante Argo CD (App of Apps)

---

## 📁 Estructura

```
microservices-helm-repo/
├── apps/
│   ├── app-of-apps.yaml         # Raíz del despliegue
│   ├── config-app.yaml
│   ├── infra-app.yaml
│   └── microservices-app.yaml
├── charts/
│   ├── config-chart/            # Helm chart del Config Server
│   ├── infra-chart/             # Helm chart de Postgres, Eureka, Gateway
│   └── microservices-chart/     # Helm chart del microservicio Inventory
```

---

## 🚀 Paso a paso para usar con Argo CD

### 1. Sube este proyecto a un repositorio Git

Ejemplo:
```
https://github.com/TU_USUARIO/microservices-helm-repo
```

### 2. Agrega el repositorio en Argo CD

#### Opción A: Desde la UI Web

1. Ve a `Settings > Repositories`
2. Click en **"Connect Repo using HTTPS/SSH"**
3. Ingresa la URL de tu repo

#### Opción B: Desde la CLI

```bash
argocd repo add https://github.com/TU_USUARIO/microservices-helm-repo.git \
  --username TU_USUARIO --password TU_PASSWORD
```

---

### 3. Crea la aplicación raíz `app-of-apps`

#### Opción A: Desde la UI

- Name: `app-of-apps`
- Project: `default`
- Repo URL: `https://github.com/TU_USUARIO/microservices-helm-repo.git`
- Path: `apps/`
- Revision: `HEAD`
- Cluster: `https://kubernetes.default.svc`
- Namespace: `argocd`

#### Opción B: Desde la terminal

```bash
kubectl apply -f apps/app-of-apps.yaml
```

---

### 4. Verifica en la UI de Argo CD

Deberías ver:
- `app-of-apps`
- `config-app` (onda -1)
- `infra-app` (onda 0)
- `microservices-app` (onda 1)

Cada uno se sincroniza automáticamente.

---

### 5. Personaliza valores

Puedes editar los valores directamente en los charts:
- `charts/config-chart/values.yaml`
- `charts/infra-chart/values.yaml`
- `charts/microservices-chart/values.yaml`

---

## 🛠 Requisitos

- Minikube o clúster Kubernetes
- Argo CD instalado
- Helm instalado
- Git

---

### 📬 Contacto

Para ayuda o preguntas, puedes abrir un issue o contactar al autor del repositorio.
