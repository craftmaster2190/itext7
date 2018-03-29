package com.itextpdf.svg.renderers;

import java.util.List;
import java.util.Map;

/**
 * Interface for SvgNodeRenderer, the renderer draws the SVG to its Pdf-canvas
 * passed in {@link com.itextpdf.layout.renderer.DrawContext}, applying styling
 * (CSS and attributes).
 */
public interface ISvgNodeRenderer {

    /**
     * Sets the parent of this renderer. The parent may be the source of
     * inherited properties and default values.
     *
     * @param parent the parent renderer
     */
    void setParent(ISvgNodeRenderer parent);

    /**
     * Gets the parent of this renderer. The parent may be the source of
     * inherited properties and default values.
     *
     * @return the parent renderer; null in case of a root node
     */
    ISvgNodeRenderer getParent();

    /**
     * Draws this element to a canvas-like object maintained in the context.
     * 
     * @param context the object that knows the place to draw this element and maintains its state
     */
    void draw(SvgDrawContext context);

    /**
     * Adds a renderer as the last element of the list of children.
     *
     * @param child any renderer
     */
    void addChild(ISvgNodeRenderer child);

    /**
     * Gets all child renderers of this object.
     * 
     * @return the list of child renderers (in the order that they were added)
     */
    List<ISvgNodeRenderer> getChildren();

    /**
     * Sets the map of XML node attributes and CSS style properties that this
     * renderer needs.
     * @param attributesAndStyles the mapping from key names to values
     */
    void setAttributesAndStyles(Map<String, String> attributesAndStyles);

    /**
     * Retrieves the property value for a given key name.
     * 
     * @param key the name of the property to search for
     * @return the value for this key, or {@code null}
     */
    String getAttribute(String key);

    void setAttribute(String key, String value);
}
