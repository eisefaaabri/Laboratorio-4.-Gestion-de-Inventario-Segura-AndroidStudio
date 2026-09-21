package com.example.myapplication

fun main() {
    // Definición de variables de producto
    val productId: Int = 101 // ID inmutable (no cambia)
    val productName: String = "Smartphone X1" // Nombre obligatorio (no nulo)
    var productDescription: String? = null // ? permite que sea nulo
    var stockQuantity: Int = 25 // Cantidad mutable (cambia con ventas)
    val unitPrice: Double = 599.99 // Precio base inmutable.

    // El compilador de Java 21/Kotlin 2.0 gestiona aquí la memoria eficientemente.
    println("--- Datos Iniciales Cargados ---")

    // 2. Lógica de Impuestos
    val TAX_RATE = 0.15 // IVA del 15%
    val totalPriceWithTax = unitPrice * (1 + TAX_RATE)

    // Nota: No puede modificar 'unitPrice' porque es 'val'.
    // Si lo intenta, Android Studio marcará un error rojo

    // 3. Uso del Operador Elvis (?:)
    // Si productDescription es null, se asigna el texto de la derecha.
    val descriptionToShow = productDescription ?: "Sin descripción disponible"
    println("Producto: $productName")
    println("Descripción: $descriptionToShow")

    // 4. Simulación de Venta
    val itemsSold = 5
    stockQuantity -= itemsSold // Actualización de variable mutable
    // 5. Generación de Reporte con Plantilla de Cadena
    val report = """
        --- REPORTE DE INVENTARIO ---
        ID: $productId | Nombre: $productName
        Precio Final: $${String.format("%.2f", totalPriceWithTax)}
        Stock Actual: $stockQuantity
        Estado: ${if (stockQuantity > 10) "Suficiente" else "Crítico"}
         -----------------------------
    """.trimIndent()
    println(report)

    // --- Desafío 2: El Validador de Precios Dinámico ---
    val inputUsuario: String? = "No quiero pagar" // Prueba 1: "650.50" | Prueba 2: "No quiero pagar"

    // Conversión Segura y Lógica de Respaldo (Elvis Operator)
    // Intenta convertir a Double; si falla (devuelve null), el operador ?: asigna 0.0
    val precioUnitario: Double = inputUsuario?.toDoubleOrNull() ?: 0.0

    // Recalcular el precio total
    val precioTotalConTax = precioUnitario * (1 + TAX_RATE)

    println("\n--- SIMULACIÓN DE ENTRADA DINÁMICA ---")
    println("Texto ingresado: $inputUsuario")
    println("Precio base validado: $$precioUnitario")
    println("Nuevo Precio Final (con IVA): $$precioTotalConTax")

}