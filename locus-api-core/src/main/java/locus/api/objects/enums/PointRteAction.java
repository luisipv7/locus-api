package locus.api.objects.enums;

/**
 * Created by menion on 15/10/2016.
 * This code is part of Locus project from Asamm Software, s. r. o.
 */
public enum PointRteAction {

	/**
	 * Special action that serve as fallback if no valid action is defined/found.
	 */
	UNDEFINED (Integer.MIN_VALUE, "undefined"),
	/**
	 * No maneuver occurs here.
	 */
	NO_MANEUVER (0, "no_maneuver"),
	/**
	 * Continue straight.
	 */
	CONTINUE_STRAIGHT (1, "straight"),
	/**
	 * No maneuver occurs here. Road name changes.
	 */
	NO_MANEUVER_NAME_CHANGE (2, "name_change"),
	/**
	 * Make a slight left.
	 */
	LEFT_SLIGHT (3, "left_slight"),
	/**
	 * Turn left.
	 */
	LEFT (4, "left"),
	/**
	 * Make a sharp left.
	 */
	LEFT_SHARP (5, "left_sharp"),
	/**
	 * Make a slight right.
	 */
	RIGHT_SLIGHT (6, "right_slight"),
	/**
	 * Turn right.
	 */
	RIGHT (7, "right"),
	/**
	 * Make a sharp right.
	 */
	RIGHT_SHARP (8, "right_sharp"),
	/**
	 * Stay left.
	 */
	STAY_LEFT (9, "stay_left"),
	/**
	 * Stay right.
	 */
	STAY_RIGHT (10, "stay_right"),
	/**
	 * Stay straight.
	 */
	STAY_STRAIGHT (11, "stay_straight"),
	/**
	 * Make a U-turn.
	 */
	U_TURN (12, "u-turn"),
	/**
	 * Make a left U-turn.
	 */
	U_TURN_LEFT (13, "u-turn_left"),
	/**
	 * Make a right U-turn.
	 */
	U_TURN_RIGHT (14, "u-turn_right"),
	/**
	 * Exit left.
	 */
	EXIT_LEFT (15, "exit_left"),
	/**
	 * Exit right.
	 */
	EXIT_RIGHT (16, "exit_right"),
	/**
	 * Take the ramp on the left.
	 */
	RAMP_ON_LEFT (17, "ramp_left"),
	/**
	 * Take the ramp on the right.
	 */
	RAMP_ON_RIGHT (18, "ramp_right"),
	/**
	 * Take the ramp straight ahead.
	 */
	RAMP_STRAIGHT (19, "ramp_straight"),
	/**
	 * Merge left.
	 */
	MERGE_LEFT (20, "merge_left"),
	/**
	 * Merge right.
	 */
	MERGE_RIGHT (21, "merge_right"),
	/**
	 * Merge.
	 */
	MERGE (22, "merge"),
	/**
	 * Enter state/province.
	 */
	ENTER_STATE (23, "enter_state"),
	/**
	 * Arrive at your destination.
	 */
	ARRIVE_DEST (24, "dest"),
	/**
	 * Arrive at your destination on the left.
	 */
	ARRIVE_DEST_LEFT (25, "dest_left"),
	/**
	 * Arrive at your destination on the right.
	 */
	ARRIVE_DEST_RIGHT (26, "dest_right"),
	/**
	 * Enter the roundabout and take the 1st exit.
	 */
	ROUNDABOUT_EXIT_1 (27, "roundabout_e1"),
	/**
	 * Enter the roundabout and take the 2nd exit.
	 */
	ROUNDABOUT_EXIT_2 (28, "roundabout_e2"),
	/**
	 * Enter the roundabout and take the 3rd exit.
	 */
	ROUNDABOUT_EXIT_3 (29, "roundabout_e3"),
	/**
	 * Enter the roundabout and take the 4th exit.
	 */
	ROUNDABOUT_EXIT_4 (30, "roundabout_e4"),
	/**
	 * Enter the roundabout and take the 5th exit.
	 */
	ROUNDABOUT_EXIT_5 (31, "roundabout_e5"),
	/**
	 * Enter the roundabout and take the 6th exit.
	 */
	ROUNDABOUT_EXIT_6 (32, "roundabout_e6"),
	/**
	 * Enter the roundabout and take the 7th exit.
	 */
	ROUNDABOUT_EXIT_7 (33, "roundabout_e7"),
	/**
	 * Enter the roundabout and take the 8th exit.
	 */
	ROUNDABOUT_EXIT_8 (34, "roundabout_e8"),
	/**
	 * Pass POI.
	 */
	PASS_PLACE (50, "pass_place");


	// unique ID of action
	private int mId;
	// text ID representation
	private String mTextId;

	/**
	 * Default constructor.
	 * @param id id of item
	 */
	PointRteAction(int id, String textId) {
		this.mId = id;
		this.mTextId = textId;
	}

	/**
	 * Get ID of current action.
	 * @return unique ID
	 */
	public int getId() {
		return mId;
	}

	/**
	 * Get text ID representation of current action.
	 * @return unique text ID
	 */
	public String getTextId() {
		return mTextId;
	}

	/**************************************************/
	// HELP TOOLS
	/**************************************************/

	// array of enums for optimized/faster access
	private static final PointRteAction[] VALUES = values();

	/**
	 * Get action defined by it's ID.
	 * @param id ID of required action
	 * @return found action or 'null' if not found
	 */
	public static PointRteAction getActionById(int id) {
		for (PointRteAction action : VALUES) {
			if (action.mId == id) {
				return action;
			}
		}

		// return action not found
		return UNDEFINED;
	}

	/**
	 * Get turn instruction from text representation.
	 * @param text text to analyze
	 * @return turn instruction
	 */
	public static PointRteAction getActionByText(String text) {
		// check text
		if (text == null || text.length() == 0) {
			return PointRteAction.UNDEFINED;
		}

		// test actions
		for (PointRteAction action : VALUES) {
			if (text.equalsIgnoreCase(action.getTextId())) {
				return action;
			}
		}

		// test on some special cases
		text = text.toLowerCase().trim();
		switch (text) {
			case "turn-left":
				return LEFT;
			case "turn-right":
				return RIGHT;
			default:
				return UNDEFINED;
		}
	}

	/**
	 * Get aciton for roundabouts, defined by number of exit.
	 * @param exitNo exit no. (supported values are 1 - 8)
	 * @return action for roundabout
	 */
	public static PointRteAction getActionRoundabout(int exitNo) {
		// check edge options
		if (exitNo < 1) {
			return PointRteAction.ROUNDABOUT_EXIT_1;
		} else if (exitNo > 8) {
			return PointRteAction.ROUNDABOUT_EXIT_8;
		}

		// return correct action
		return getActionById(ROUNDABOUT_EXIT_1.getId() - 1 + exitNo);
	}

	// ACTION FOR NAVIGATION ANGLES

	// maximum value for straight angle
	private static final int ANGLE_NO_MAX = 30;
	// maximum value for slight angle turn
	private static final int ANGLE_SLIGHT_MAX = 45;
	// maximum value for normal angle turn
	private static final int ANGLE_REGULAR_MAX = 120;
	// maximum value for hard angle turn
	private static final int ANGLE_HARD_MAX = 170;

	/**
	 * Get angle for certain angle.
	 * @param angle computed angle
	 * @return action
	 */
	public static PointRteAction getActionByAngle(float angle) {
		if (angle < ANGLE_NO_MAX) {
			return PointRteAction.CONTINUE_STRAIGHT;
		} else if (angle < ANGLE_SLIGHT_MAX) {
			return PointRteAction.RIGHT_SLIGHT;
		} else if (angle < ANGLE_REGULAR_MAX) {
			return PointRteAction.RIGHT;
		} else if (angle < ANGLE_HARD_MAX) {
			return PointRteAction.RIGHT_SHARP;
		} else if (angle < 180) {
			return PointRteAction.U_TURN_RIGHT;
		} else if (angle < 360 - ANGLE_HARD_MAX) {
			return PointRteAction.U_TURN_LEFT;
		} else if (angle < 360 - ANGLE_REGULAR_MAX) {
			return PointRteAction.LEFT_SHARP;
		} else if (angle < 360 - ANGLE_SLIGHT_MAX) {
			return PointRteAction.LEFT;
		} else if (angle < 360 - ANGLE_NO_MAX) {
			return PointRteAction.LEFT_SLIGHT;
		} else {
			return PointRteAction.CONTINUE_STRAIGHT;
		}
	}

}
