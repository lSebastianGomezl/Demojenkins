package runners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class EjecutarRunnersUI extends JFrame{
    private JComboBox<String> comboRunners;

    public EjecutarRunnersUI() {
        setTitle("GSV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null); // Centrado en pantalla
        setLayout(new GridBagLayout());

        Font fuente = new Font("Arial", Font.PLAIN, 18);

        JLabel lbl = new JLabel("Test a ejecutar:");
        lbl.setFont(fuente);

        comboRunners = new JComboBox<>();
        comboRunners.setFont(fuente);
        comboRunners.addItem("Seleccionar");
        comboRunners.addItem("Configuracion Parametros");
        comboRunners.addItem("Plan de Resultado Sorteo");
        comboRunners.addItem("Crear Plantillas");
        comboRunners.addItem("Crear Sorteo");
        comboRunners.addItem("Crear Tipo Balota");
        comboRunners.addItem("Programacion Sorteo");

        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setFont(fuente);

        // Botón para ejecutar runner
        btnIniciar.addActionListener((ActionEvent e) -> {
            String seleccion = (String) comboRunners.getSelectedItem();
            if (seleccion == null || seleccion.equals("Seleccionar")) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un runner");
                return;
            }

            // Mapeo de nombres a clases Runner
            String clase = "";
            switch (seleccion) {
                case "Configuracion Parametros":
                    clase = "runners.configuracionparametros.RunnerConfiguracionParametros";
                    break;
                case "Plan de Resultado Sorteo":
                    clase = "runners.configuracionplanderesultado.RunnerPlanDeResultadoSorteo";
                    break;
                case "Crear Plantillas":
                    clase = "runners.creacionplantillas.RunnerCrearPlantillas";
                    break;
                case "Crear Sorteo":
                    clase = "runners.crearsorteo.RunnerCrearSorteo";
                    break;
                case "Crear Tipo Balota":
                    clase = "runners.creartipobalota.RunnerCrearTipoBalota";
                    break;
                case "Programacion Sorteo":
                    clase = "runners.programacionsorteo.RunnerProgramacionSorteo";
                    break;
            }

            if (!clase.isEmpty()) {
                String finalClase = clase;

                // Deshabilitar botón mientras corre
                btnIniciar.setEnabled(false);
                comboRunners.setEnabled(false);

                // Ejecutar gradlew en un hilo aparte
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() {
                        try {
                            // Ejecuta gradlew test con el runner seleccionado
                            ProcessBuilder pb = new ProcessBuilder(
                                    "cmd", "/c", "gradlew", "test", "--tests", finalClase
                            );
                            pb.directory(new File(System.getProperty("user.dir"))); // Carpeta del proyecto
                            pb.inheritIO(); // Redirige salida a la consola
                            Process process = pb.start();
                            process.waitFor();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null,
                                    "Error ejecutando el runner: " + ex.getMessage());
                        }
                        return null;
                    }

                    @Override
                    protected void done() {
                        JOptionPane.showMessageDialog(null,
                                "Ejecución de " + seleccion + " completada exitosamente!");

                        // Cierra la app para que se genere el reporte
                        System.exit(0);
                    }
                };
                worker.execute();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0; gbc.gridy = 0;
        add(lbl, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        add(comboRunners, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0; gbc.gridy = 1;
        add(btnIniciar, gbc);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EjecutarRunnersUI().setVisible(true);
        });
    }

}
