# Kubernetes - Guia de Estudos

## 📌 Introdução

O **Kubernetes (K8s)** é um orquestrador de containers responsável por automatizar:

- Deploy de aplicações
- Escalabilidade
- Gerenciamento
- Recuperação de falhas

Ele trabalha sobre um conjunto de máquinas chamado **Cluster**.

---

## 🧱 Cluster

Um **cluster Kubernetes** é um conjunto de máquinas que trabalham juntas.

### Tipos de máquinas:

- **Master (Control Plane)**:
  - Responsável pelo gerenciamento do cluster
  - Contém componentes como:
    - API Server
    - Scheduler
    - Controller Manager
    - etcd

- **Nodes (Workers)**:
  - Executam as aplicações (containers)
  - Contêm:
    - Kubelet
    - Container Runtime (Docker, containerd, etc)

---

## 🔌 API e kubectl

- A **API Server** é o coração do cluster
- Toda comunicação passa por ela

### kubectl

CLI utilizada para interagir com o cluster:

```
kubectl get pods
kubectl apply -f arquivo.yaml
kubectl delete pod nome-do-pod
```

---

## 📦 Pods

### Conceito

- No Docker → unidade = container  
- No Kubernetes → unidade = **Pod**

Um **Pod** é o menor objeto do Kubernetes e pode conter:

- 1 ou mais containers
- Compartilham:
  - IP
  - Network namespace
  - Storage (volumes)

### ⚠️ Observações importantes:

- Containers dentro do mesmo pod **não podem usar a mesma porta**
- O IP pertence ao Pod, não ao container
- Pods são **efêmeros**:
  - Se falharem, são recriados
  - O IP pode mudar

---

## ⚙️ Criando Pods

### Imperativo

```
kubectl run nginx-pod --image=nginx:latest
```

### Declarativo (recomendado)

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: primeiro-pod-declarativo
spec:
  containers:
    - name: nginx-container
      image: nginx:latest
```

```
kubectl apply -f primeiro-pod.yaml
```

---

## 🔍 Comandos úteis

```
kubectl describe pod nginx-pod
kubectl edit pod nginx-pod
kubectl delete pod nginx-pod
kubectl exec -it nome-do-pod -- bash
```

---

## 🌐 Comunicação e Serviços (Service)

Pods são efêmeros, então não é confiável acessá-los diretamente via IP.

### Service (svc)

Abstração que:

- Expõe Pods
- Faz load balancing
- Fornece DNS interno
- Possui IP estável

---

## 🔗 Tipos de Service

### 1. ClusterIP (default)

- Comunicação **interna** entre pods

```yaml
apiVersion: v1
kind: Service
metadata:
  name: svc-pod-2
spec:
  type: ClusterIP
  selector:
    app: segundo-pod
  ports:
    - port: 80
      targetPort: 80
```

---

### 2. NodePort

- Expõe aplicação externamente via porta do nó

Faixa padrão: **30000 - 32767**

```yaml
apiVersion: v1
kind: Service
metadata:
  name: svc-pod-1
spec:
  type: NodePort
  selector:
    app: primeiro-pod
  ports:
    - port: 80
      targetPort: 80
      nodePort: 30000
```

Acesso:
```
http://IP_DO_NODE:30000
```

---

### 3. LoadBalancer

- Cria um Load Balancer no provedor cloud
- Internamente também é:
  - ClusterIP + NodePort

```yaml
apiVersion: v1
kind: Service
metadata:
  name: svc-pod-1-loadbalancer
spec:
  type: LoadBalancer
  selector:
    app: primeiro-pod
  ports:
    - port: 80
      targetPort: 80
```

---

## 🏷️ Labels e Selectors

### Labels (nos Pods)

```yaml
metadata:
  labels:
    app: segundo-pod
```

### Selectors (nos Services)

```yaml
selector:
  app: segundo-pod
```

➡️ O Service encontra os Pods através dessas labels.

---

## 🔐 ConfigMap

Usado para externalizar configurações.

### Exemplo:

```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: db-configmap
data:
  MYSQL_ROOT_PASSWORD: q1w2e3r4
  MYSQL_PASSWORD: q1w2e3r4
  MYSQL_DATABASE: empresa
```

---

## 🔗 Usando ConfigMap em Pods

### Variável por variável:

```yaml
env:
  - name: MYSQL_ROOT_PASSWORD
    valueFrom:
      configMapKeyRef:
        name: db-configmap
        key: MYSQL_ROOT_PASSWORD
```

---

## ⚠️ Boas práticas (IMPORTANTE)

- ❌ Não use Pods diretamente em produção  
  ✅ Use:
  - Deployment
  - ReplicaSet

- ❌ Não exponha NodePort em produção  
  ✅ Use:
  - LoadBalancer ou Ingress

- ❌ Não use ConfigMap para dados sensíveis  
  ✅ Use:
  - Secrets

---

## 🚀 Próximos passos recomendados

Para evoluir no Kubernetes:

- Deployments
- ReplicaSets
- Ingress
- Volumes (PV/PVC)
- Secrets
- HPA (Horizontal Pod Autoscaler)

---

## 🧠 Resumo mental

- Pod = unidade básica
- Service = comunicação estável
- Cluster = conjunto de máquinas
- Node = executa containers
- Master = controla tudo
