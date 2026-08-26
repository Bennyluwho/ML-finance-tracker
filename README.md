# Personal Finance ML Tracker

A privacy-focused personal finance application for automatically tracking expenses from **receipt photos, bank transaction exports, and manual entries**.

The project is designed both as a practical personal finance tool and as an end-to-end **machine learning engineering project**, with a focus on computer vision, document understanding, transaction classification, data pipelines, and secure deployment.

> **Project Status:** 🚧 In Development

---

## Overview

Keeping track of everyday spending manually is tedious. This project aims to make expense tracking as simple as taking a picture of a receipt.

The intended workflow is:

```text
Take Receipt Photo
        ↓
Upload to Application
        ↓
Image Preprocessing
        ↓
OCR / Document Understanding
        ↓
Extract Transaction Information
        ↓
ML Expense Classification
        ↓
User Verification
        ↓
Store Transaction
        ↓
Spending Dashboard
```

The application will eventually support three primary methods of entering expenses:

1. **Receipt scanning** — photograph and automatically process a receipt.
2. **Statement importing** — import supported bank transaction exports.
3. **Manual entry** — manually record transactions when necessary.

The goal is to combine traditional software engineering with a progressively more sophisticated ML pipeline rather than relying entirely on third-party AI APIs.

---

# Core Features

### Expense Tracking

Transactions contain information such as:

```text
Merchant
Date
Amount
Category
Source
```

Users can view spending across:

- Weekly periods
- Monthly periods
- Yearly periods
- Spending categories

### Receipt Scanning

Receipt images can be uploaded directly from a phone or computer.

The processing pipeline will progressively support:

```text
Receipt Image
      ↓
Image Preprocessing
      ↓
Receipt Detection
      ↓
Perspective Correction
      ↓
OCR
      ↓
Field Extraction
      ↓
Expense Classification
```

### Transaction Classification

A PyTorch model will be developed to classify transactions into categories such as:

```text
Groceries
Dining
Transportation
Housing
Utilities
Entertainment
Shopping
Subscriptions
Other
```

### Human Verification

ML-generated transactions are not immediately trusted.

Before being recorded, predictions can be reviewed and corrected:

```text
Merchant:   Example Market       ✓
Date:       2026-08-25           ✓
Total:      $42.81               ✓
Category:   Shopping             ✎

                  ↓

Category corrected to:

            Groceries
```

Corrections can later become labeled examples for improving the ML system.

---

# Machine Learning Goals

This project is also intended as a practical environment for learning the complete ML lifecycle.

Rather than treating machine learning as a single API call, the project will explore:

- PyTorch
- Computer vision
- OpenCV
- OCR
- Document understanding
- Classification
- Transfer learning
- Dataset construction
- Data augmentation
- Training and validation
- Model evaluation
- Hyperparameter tuning
- Model inference
- Confidence scoring
- Error analysis
- Model serving
- ML feedback loops

The ML architecture will evolve as the project develops.

---

# System Architecture

```text
                     ┌─────────────────┐
                     │     Client      │
                     │                 │
                     │ Receipt Upload  │
                     │ Manual Entry    │
                     │ Statement Import│
                     └────────┬────────┘
                              │
                              ▼
                     ┌─────────────────┐
                     │    Frontend     │
                     │ React / Next.js │
                     └────────┬────────┘
                              │
                           REST API
                              │
                              ▼
                     ┌─────────────────┐
                     │  Spring Boot    │
                     │     Backend     │
                     └───────┬─────────┘
                             │
                ┌────────────┴────────────┐
                │                         │
                ▼                         ▼
        ┌──────────────┐          ┌───────────────┐
        │ PostgreSQL   │          │ Python ML     │
        │              │          │ Service       │
        │ Transactions │          └───────┬───────┘
        │ Categories   │                  │
        │ Metadata     │           ┌──────┴──────┐
        └──────────────┘           │             │
                                  ▼             ▼
                               OpenCV        PyTorch
                                  │             │
                                  └──────┬──────┘
                                         │
                                         ▼
                                   ML Inference
```

---

# Technology Stack

### Frontend

- React / Next.js
- TypeScript
- Responsive mobile-first interface

### Backend

- Java
- Spring Boot
- Spring Data JPA
- REST APIs

### Database

- PostgreSQL

### Machine Learning

- Python
- PyTorch
- OpenCV
- OCR / document-processing tools
- Jupyter notebooks for experimentation

### Infrastructure

- Docker
- Docker Compose
- Linux
- Git / GitHub
- Private network access for production infrastructure

---

# Repository Structure

The planned repository structure is:

```text
personal-finance-ml/
│
├── frontend/
│   ├── src/
│   ├── public/
│   └── package.json
│
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── ml/
│   ├── src/
│   │   ├── preprocessing/
│   │   ├── inference/
│   │   ├── training/
│   │   └── evaluation/
│   │
│   ├── notebooks/
│   │
│   ├── tests/
│   │
│   └── requirements.txt
│
├── docker-compose.yml
├── .env.example
├── .gitignore
├── README.md
└── LICENSE
```

Large datasets, trained model artifacts, private financial information, secrets, and production configuration are intentionally excluded from source control.

---

# Development Strategy

Development and production environments are intentionally separated.

## Development

Development occurs using local services and synthetic/test financial data.

```text
Developer Machine

Frontend
Backend
ML experimentation
Development PostgreSQL
Synthetic receipts
Synthetic transactions
```

The development environment must never require access to real production financial information.

## Production

The production environment runs separately on private infrastructure.

```text
Private Production Environment

Containerized Services
Database
Backend
ML Inference
Frontend
```

Specific production infrastructure information is intentionally **not documented in this public repository**.

---

# Project Roadmap

## Phase 0 — Architecture & Project Setup

- Define system architecture
- Create repository structure
- Configure frontend/backend/ML projects
- Configure development database
- Establish environment-variable strategy
- Configure `.gitignore`
- Generate synthetic development data

---

## Phase 1 — Finance Tracker MVP

Build a functional expense tracker without ML.

Features:

- Create transaction
- Edit transaction
- Delete transaction
- Transaction history
- Expense categories
- Weekly spending
- Monthly spending
- Yearly spending
- Basic analytics dashboard

**Primary focus:** full-stack application development.

---

## Phase 2 — Receipt Image Pipeline

Add receipt uploads and traditional computer vision preprocessing.

Experiments include:

- Grayscale conversion
- Denoising
- Thresholding
- Edge detection
- Receipt boundary detection
- Perspective correction
- Deskewing
- Image normalization

**Primary focus:** OpenCV and computer vision fundamentals.

---

## Phase 3 — OCR

Extract text from processed receipts.

```text
Image
 ↓
Preprocessing
 ↓
OCR
 ↓
Raw Receipt Text
```

Evaluate how different preprocessing techniques affect OCR performance.

**Primary focus:** document processing and CV experimentation.

---

## Phase 4 — PyTorch Transaction Classifier

Develop the first custom ML model.

```text
Transaction Description
        ↓
PyTorch Model
        ↓
Expense Category
```

Training pipeline:

```text
Dataset
   ↓
Train / Validation / Test
   ↓
PyTorch Dataset
   ↓
DataLoader
   ↓
Model Training
   ↓
Validation
   ↓
Evaluation
   ↓
Saved Model
   ↓
Inference
```

Evaluation will include metrics such as:

- Accuracy
- Precision
- Recall
- F1 score
- Confusion matrix

**Primary focus:** fundamental machine learning and PyTorch.

---

## Phase 5 — Receipt Understanding

Develop more sophisticated extraction for:

```text
Merchant
Date
Subtotal
Tax
Total
```

Potential approaches include pretrained document-understanding models and transfer learning.

**Primary focus:** document AI and applied ML.

---

## Phase 6 — ML Feedback Loop

User corrections can optionally become training examples.

```text
Prediction
    ↓
User Review
    ↓
Correction
    ↓
Labeled Example
    ↓
Training Dataset
    ↓
Retraining
    ↓
Model Evaluation
```

New models should only replace existing models when evaluation demonstrates measurable improvement.

**Primary focus:** ML lifecycle and data-centric development.

---

## Phase 7 — Statement Importing

Support structured bank transaction exports.

Preferred ingestion order:

```text
CSV / structured export
        ↓
PDF when necessary
```

Pipeline:

```text
Transaction Export
       ↓
Local Parser
       ↓
Normalization
       ↓
Duplicate Detection
       ↓
Classification
       ↓
User Review
       ↓
Database
```

**Primary focus:** ETL and financial data pipelines.

---

## Phase 8 — Deployment & MLOps

Containerize and deploy the application.

Potential services:

```text
frontend
backend
ml-service
postgres
```

Areas of focus:

- Docker
- Service isolation
- Model serving
- Model versioning
- Logging
- Database backups
- Authentication
- Secure networking
- Deployment automation

**Primary focus:** production ML engineering.

---

## Phase 9 — Evaluation & Portfolio Documentation

Document actual experimental results.

Examples include:

```text
Classification Accuracy
Macro F1

OCR Accuracy

Merchant Extraction Accuracy
Date Extraction Accuracy
Total Extraction Accuracy

Inference Latency
```

Results published here will come from reproducible experiments rather than estimated or fabricated metrics.

---

# Privacy & Security

Financial data is highly sensitive.

Security and data minimization are therefore core design requirements rather than optional features.

### Data Minimization

The application should store only the information required for expense tracking.

Where possible, the database stores:

```text
Merchant
Transaction Date
Amount
Category
Source Type
```

The application does **not require storing**:

```text
Full bank account numbers
Routing numbers
Debit/credit card numbers
Bank credentials
Authentication credentials
```

Raw financial documents should be retained only when explicitly necessary.

---

# Public Repository Security Policy

This repository is intended to be publicly viewable.

Therefore, the following information must **NEVER** be committed:

- `.env` files
- API keys
- passwords
- database credentials
- SSH private keys
- authentication tokens
- cookies or session tokens
- VPN credentials
- private network addresses
- private DNS names
- internal hostnames
- production IP addresses
- server usernames
- production database dumps
- real bank statements
- real receipts containing personal information
- account numbers
- routing numbers
- card information
- personally identifying financial data
- production logs containing sensitive information

Infrastructure examples in documentation should use placeholders such as:

```text
<PRIVATE_SERVER>
<PRIVATE_HOST>
<PRIVATE_IP>
<DATABASE_HOST>
<USERNAME>
```

Never real values.

---

# Environment Variables

Secrets and environment-specific configuration must be provided outside source control.

Example:

```text
DATABASE_URL=<DATABASE_URL>
DATABASE_USERNAME=<DATABASE_USERNAME>
DATABASE_PASSWORD=<DATABASE_PASSWORD>

ML_SERVICE_URL=<ML_SERVICE_URL>

JWT_SECRET=<JWT_SECRET>
```

A public `.env.example` may document **variable names**, but never actual credentials or production values.

`.env` must remain ignored by Git.

Example `.gitignore` rules:

```gitignore
# Environment variables
.env
.env.*
!.env.example

# Python
.venv/
__pycache__/
*.pyc

# ML artifacts
models/
checkpoints/
*.pt
*.pth

# Datasets
data/
datasets/

# Financial documents
receipts/
statements/
uploads/

# Java
target/

# Node
node_modules/
.next/

# IDE / OS
.vscode/
.idea/
.DS_Store
Thumbs.db
```

---

# Development Data

Public development and testing should use **synthetic financial information**.

Example:

```json
{
  "merchant": "Example Grocery",
  "date": "2026-01-15",
  "amount": 42.81,
  "category": "Groceries"
}
```

Real personal financial records must not be included in:

- tests
- screenshots
- Git commits
- GitHub issues
- documentation
- sample datasets

---

# ML Dataset Security

Personal receipts and financial transactions used for experimentation are considered private data.

They should remain outside the public repository.

If public datasets are used for model development, their licenses and sources should be documented separately.

Any personal dataset should remain in private storage and be excluded from Git.

---

# Logging

Production logs should avoid recording sensitive request contents.

Avoid logging:

```text
Uploaded document contents
Financial account information
Authentication tokens
Raw receipt OCR when unnecessary
Full transaction payloads
```

Prefer operational logs such as:

```text
Receipt processing completed
Classification completed
Transaction created
Model inference: 84 ms
```

---

# Security Before Every Push

Before publishing changes:

1. Review staged files.

```bash
git status
git diff --cached
```

2. Verify that no environment files are staged.

3. Verify that no receipts/statements are staged.

4. Verify that configuration contains no private addresses or credentials.

5. Verify that screenshots contain no personal information.

6. Verify that logs contain no sensitive information.

7. Only then push to the public repository.

> `.gitignore` prevents many accidents, but it should never be considered the only security boundary.

If a secret is accidentally committed, removing it in a later commit is **not sufficient**. Assume the secret has been exposed, revoke/rotate it, and remove the sensitive data from repository history when appropriate.

---

# Security Philosophy

The project follows several basic principles:

**Least privilege**

Services receive only the access required to perform their function.

**Data minimization**

Sensitive financial information is not collected or retained unless necessary.

**Environment separation**

Development data and production financial data remain separate.

**Private infrastructure**

Production infrastructure does not need to be described or exposed by the public source repository.

**Human verification**

ML predictions affecting financial records can be reviewed before being accepted.

**Secure by default**

A feature that requires unnecessarily exposing sensitive financial information should be redesigned rather than accepted for convenience.

---

# Project Goals

By completion, this project aims to demonstrate practical experience across:

### Machine Learning

- PyTorch
- Computer vision
- OCR
- Classification
- Transfer learning
- Model evaluation
- ML inference

### ML Engineering

- Data pipelines
- Dataset management
- Model serving
- Feedback loops
- Model evaluation
- Model versioning
- Production inference

### Software Engineering

- Java
- Spring Boot
- REST APIs
- PostgreSQL
- React / Next.js
- TypeScript

### Infrastructure

- Docker
- Linux
- Private networking
- Environment management
- Secure deployment

---

## Long-Term Goal

The final system should provide a simple workflow:

```text
Take Photo
    ↓
Review Expense
    ↓
Save
```

while hiding the complexity of:

```text
Computer Vision
OCR
Machine Learning
Backend Processing
Database Storage
Analytics
Security
```

behind a simple personal finance experience.

The broader engineering objective is to build an end-to-end ML system that progresses from experimentation to a secure, deployed application while maintaining strict separation between **public source code and private financial infrastructure**.
