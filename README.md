# qa-automation-saucedemo-java (Java + Selenium)
Proyecto de automatización E2E para un e-commerce (SauceDemo), simulando un entorno real de QA Automation.

## Stack
- Java 17
- Maven
- Selenium 4
- JUnit 5
- Page Object Model
- CI: GitHub Actions

## Qué cubre
- Login: válido / inválido / usuario bloqueado
- Carrito: añadir producto
- Checkout: flujo completo + validaciones

## Cómo ejecutar
```bash
mvn test

## Nota sobre warnings de CDP
Al ejecutar con versiones recientes de Chrome, Selenium puede mostrar warnings de CDP (DevTools).
No afecta a estos tests porque no usamos funcionalidades CDP (solo UI E2E con WebDriver).