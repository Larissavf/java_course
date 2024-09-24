/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section3_apis.part3_protein_sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public class Protein implements Comparable<Protein> {
    private final String name;
    private final String accession;
    private final String aminoAcidSequence;
    private GOannotation goAnnotation;
    private double molecularWeight;
    private Map<Character, Double> aminoMoleculairWeight = Map.of('I', 131.1736, 'L', 131.1736, 'L',  146.1882,
            'M', 149.2124, 'F', 165.19, 'T', 119.1197, 'W', 204.2262, 'V', 117.1469, 'R', 174.2017,
            'H', 155.1552, 'A', 89.0935, 'N', 132.1184, 'D', 133.1032, 'C', 121.159, 'E', 147.1299,
            'Q', 146.1451, 'G' , 75.0669, 'P', 115.131, 'S', 105.093, 'Y', 181.1894);

    /**
     * constructs without GO annotation;
     * @param name the protein name
     * @param accession the accession number
     * @param aminoAcidSequence the proteins amino acid sequence
     */
    public Protein(String name, String accession, String aminoAcidSequence) {
        this.name = name;
        this.accession = accession;
        this.aminoAcidSequence = aminoAcidSequence;
    }

    /**
     * constructs with main properties.
     * @param name the protein name
     * @param accession the accession number
     * @param aminoAcidSequence the proteins amino acid sequence
     * @param goAnnotation the GO annotation
     */
    public Protein(String name, String accession, String aminoAcidSequence, GOannotation goAnnotation) {
        this.name = name;
        this.accession = accession;
        this.aminoAcidSequence = aminoAcidSequence;
        this.goAnnotation = goAnnotation;
    }

    @Override
    public int compareTo(Protein other) {
        return CharSequence.compare(this.name, other.name);
    }
    
    /**
     * provides a range of possible sorters, based on the type that is requested.
     * @param type the sorting type that is required
     * @return proteinSorter
     */
    public static Comparator<Protein> getSorter(SortingType type) {
    switch (type) {
        case PROTEIN_NAME : class proteinNameComparator implements Comparator<Protein> {
            @Override
            public int compare(Protein o1, Protein o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        case GO_ANNOTATION : class goAnnotationComparator implements Comparator<GOannotation> {
            @Override
            public int compare(GOannotation o1, GOannotation o2) {
                int biologicalProcess = o1.getBiologicalProcess().compareToIgnoreCase(o2.getBiologicalProcess());
                if (biologicalProcess == 0) {
                    int cellularComponent = o1.getCellularComponent().compareToIgnoreCase(o2.getCellularComponent());
                    if (cellularComponent == 0) {
                        return o1.getMolecularFunction().compareToIgnoreCase(o2.getMolecularFunction());
                    }
                    return cellularComponent;
                } return biologicalProcess;
            }

    }
        case PROTEIN_WEIGHT : class proteinWeightComparator implements Comparator<Protein> {
            @Override
            public int compare(Protein o1, Protein o2) {
            return Double.compare(o1.getMolecularWeight(), o2.getMolecularWeight());
            }
        }
        case ACCESSION_NUMBER : class accessionNumberComparator implements Comparator<Protein> {
            @Override
            public int compare(Protein o1, Protein o2) {
                return o1.accession.compareToIgnoreCase(o2.accession);
            }
        }
        default : throw new IllegalStateException("Unexpected value: " + type);
    }}

    private void MolecularWeight() {
        double molecularWeight = 0.0;
        for (char letter : getAminoAcidSequence().toCharArray()) {
            if (aminoMoleculairWeight.containsKey(letter)) {
                molecularWeight =+ aminoMoleculairWeight.get(letter);
            } else{
            throw new IllegalArgumentException("Not a acceptable aminoacid combo" + getAminoAcidSequence());
        }}
        this.molecularWeight = molecularWeight;
    }

    public double getMolecularWeight() {
        return molecularWeight;
    }

    /**
     *
     * @return name the protein name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return accession the accession number
     */
    public String getAccession() {
        return accession;
    }

    /**
     *
     * @return aminoAcidSequence the amino acid sequence
     */
    public String getAminoAcidSequence() {
        return aminoAcidSequence;
    }

    /**
     *
     * @return GO annotation
     */
    public GOannotation getGoAnnotation() {
        return goAnnotation;
    }

    @Override
    public String toString() {
        return "Protein{" + "name=" + name + ", accession=" + accession + ", aminoAcidSequence=" + aminoAcidSequence + '}';
    }

}
