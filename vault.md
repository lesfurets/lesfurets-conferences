# vault

## Title

Deploying your application secrets: Hashicorp Vault and continuous delivery

## Abstract

Managing application secrets, like database credentials, passphrases, salts and
private keys, is hard. The availability of those elements are critical to the
application, yet they need to be properly secured to reduce the attack surface
on your system. Most secret management systems, like Hashicorp Vault, are used
as a centralized database, but it creates a single point of failure and it
requires extra care in hardening the security of that system. How about
deploying your secrets, in Hashicorp Vault, alongside your application? By
leveraging your build infrastructure, you can deploy a copy of your secrets, in
a Vault that is secured using a one-time token, accessible only by your
application. In this presentation, we'll show a continuous delivery pipeline
that enables that approach, talk about the implications of handling secrets in
your build infrastructure, and use threat modeling to verify the security of
the deployed Vault.

## Outline

- Context
    - Secrets (insurer credentials, keys, passphrase, salt, database, etc.)
    - Production environment (app servers, batches, backoffice)
    - Build environment (continuous delivery setup)
    - Threat model overview: (1) prod machine (2) build env (3) source code
- Problems (in that order)
    - How do we remove secrets from production machines?
    - How do we remove secrets from build environment? (not done)
    - How do we remove secrets from source code? (not done)
- Why Vault?
    - Global concepts: seal (key) + auth (one-time token)
    - With seal and auth, you can implement a one-time connection
    - Lightweight, performant and battle hardened
- Continuous delivery pipeline
    - Building a vault copy (from local secrets store, only what you need)
    - Build infrastructure implications (secrets written on disk, ramfs)
    - Artifact management (sealed vault is public, key and token are not)
    - Deployment (send vault to production, remote unseal)
    - Application startup (start app with one-time token, startup checks)
- Threat model
    - Production servers threat model
    - Build pipeline threat model
- Performance / scalability
    - Stats from our usage
    - Decentralized nature makes it easier to manage

## Outline (v1)

- Context
    - Secrets (insurer creds, keys, passphrase, salt, database, etc.)
    - Production environment (app servers, batches, backoffice)
    - Build environment (continuous delivery setup)
    - Threat model overview: (1) app machine (2) build env (3) source code
    - (Legislation (gdpr, encryption)) end
    - (Development environment (secret in code, everybody all access)) end
- Problem
    - How do we remove secrets from production machines?
    - -How do we remove secrets from source code?-
    - -How do we remove secrets from build env?-
- Meet Vault
    - Global concepts: seal, auth, data
    - What happens if we lose connectivity? (1) bdd ok (2) vault ko
    - Ship vault with application!

