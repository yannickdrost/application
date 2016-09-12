/*
 * This file is part of the application library that simplifies common
 * initialization and helps setting up any java program.
 * 
 * Copyright (C) 2016 Yannick Drost, all rights reserved.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.drost.application.plaf.dawn;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Painter;

/**
 * @author kimschorat
 *
 */
class ScrollBarButtonPainter implements Painter<Component>
{
	private Color background, foreground;
	
	ScrollBarButtonPainter(Color background, Color foreground)
	{
		this.background = background;
		this.foreground = foreground;
	}
	

	@Override
	public void paint( Graphics2D g, Component object, int width, int height )
	{
		width = width/4*3;
		
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
		
		GradientPaint gradient = new GradientPaint(0, 0, background, 0, height, background.darker( ));
		g.setPaint( gradient );
		g.fillRoundRect( 1, 1, width-2, height-2, 7, 7 );
		
		g.setColor( new Color(12, 12, 12) );
		g.drawRoundRect( 1, 1, width-2, height-2, 7, 7 );
		
		g.setColor( foreground );
		int[] x = {width/3-1, (width/3)*2, (width/3)*2};
		int[] y = {height/2, height/3-1, (height/3)*2+1};
		
		g.fillPolygon( x, y, 3 );
	}
}