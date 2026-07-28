// Jennifer Joseph
// cs 330 module eight assignment
// this program demonstrates basic computer graphics concepts including animation user interaction and collision detection


#include <GLFW/glfw3.h>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <cmath>

using namespace std;

const float PI = 3.14159f;

// returns a random color value
float RandomColor()
{
	return rand() / (float)RAND_MAX;
}

class Brick
{
public:
	float x;
	float y;
	float width;
	float height;
	float red;
	float green;
	float blue;
	bool active;

	// creates a brick
	Brick(float xPosition, float yPosition, float brickWidth,
		float brickHeight, float r, float g, float b)
	{
		x = xPosition;
		y = yPosition;
		width = brickWidth;
		height = brickHeight;
		red = r;
		green = g;
		blue = b;
		active = true;
	}

	// draws the brick
	void Draw()
	{
		if (!active)
		{
			return;
		}

		glColor3f(red, green, blue);

		glBegin(GL_QUADS);

		glVertex2f(x - width / 2.0f, y - height / 2.0f);
		glVertex2f(x + width / 2.0f, y - height / 2.0f);
		glVertex2f(x + width / 2.0f, y + height / 2.0f);
		glVertex2f(x - width / 2.0f, y + height / 2.0f);

		glEnd();
	}
};

class Circle
{
public:
	float x;
	float y;
	float radius;
	float speedX;
	float speedY;
	float red;
	float green;
	float blue;
	int collisionDelay;

	// creates a circle
	Circle(float xPosition, float yPosition,
		float xSpeed, float ySpeed)
	{
		x = xPosition;
		y = yPosition;
		radius = 0.05f;
		speedX = xSpeed;
		speedY = ySpeed;
		red = RandomColor();
		green = RandomColor();
		blue = RandomColor();
		collisionDelay = 0;
	}

	// moves the circle
	void Move()
	{
		x += speedX;
		y += speedY;

		// bounces from the left and right edges
		if (x + radius >= 1.0f || x - radius <= -1.0f)
		{
			speedX = -speedX;
		}

		// bounces from the top and bottom edges
		if (y + radius >= 1.0f || y - radius <= -1.0f)
		{
			speedY = -speedY;
		}

		if (collisionDelay > 0)
		{
			collisionDelay--;
		}
	}

	// checks for a brick collision
	void CheckBrickCollision(Brick& brick)
	{
		if (!brick.active)
		{
			return;
		}

		float distanceX = fabs(x - brick.x);
		float distanceY = fabs(y - brick.y);

		if (distanceX <= brick.width / 2.0f + radius &&
			distanceY <= brick.height / 2.0f + radius)
		{
			// removes the brick
			brick.active = false;

			// changes the vertical direction
			speedY = -speedY;
		}
	}

	// checks for a circle collision
	void CheckCircleCollision(Circle& other)
	{
		float differenceX = other.x - x;
		float differenceY = other.y - y;

		float distance = sqrt(
			differenceX * differenceX +
			differenceY * differenceY
		);

		if (distance <= radius + other.radius &&
			collisionDelay == 0 &&
			other.collisionDelay == 0)
		{
			// reverses both circles
			speedX = -speedX;
			speedY = -speedY;

			other.speedX = -other.speedX;
			other.speedY = -other.speedY;

			// changes both circle colors
			red = RandomColor();
			green = RandomColor();
			blue = RandomColor();

			other.red = RandomColor();
			other.green = RandomColor();
			other.blue = RandomColor();

			// prevents repeated collisions
			collisionDelay = 20;
			other.collisionDelay = 20;
		}
	}

	// draws the circle
	void Draw()
	{
		glColor3f(red, green, blue);

		glBegin(GL_POLYGON);

		for (int i = 0; i < 40; i++)
		{
			float angle = i * 2.0f * PI / 40.0f;

			glVertex2f(
				x + cos(angle) * radius,
				y + sin(angle) * radius
			);
		}

		glEnd();
	}
};

// creates the brick pattern
void CreateBricks(vector<Brick>& bricks)
{
	bricks.push_back(Brick(-0.45f, 0.55f, 0.25f, 0.12f, 1.0f, 0.2f, 0.2f));
	bricks.push_back(Brick(-0.15f, 0.55f, 0.25f, 0.12f, 1.0f, 0.5f, 0.1f));
	bricks.push_back(Brick(0.15f, 0.55f, 0.25f, 0.12f, 1.0f, 0.8f, 0.1f));
	bricks.push_back(Brick(0.45f, 0.55f, 0.25f, 0.12f, 0.2f, 0.8f, 0.2f));

	bricks.push_back(Brick(-0.30f, 0.35f, 0.25f, 0.12f, 0.2f, 0.6f, 1.0f));
	bricks.push_back(Brick(0.00f, 0.35f, 0.25f, 0.12f, 0.4f, 0.3f, 1.0f));
	bricks.push_back(Brick(0.30f, 0.35f, 0.25f, 0.12f, 0.8f, 0.2f, 0.8f));
}

int main()
{
	srand((unsigned int)time(NULL));

	// starts glfw
	if (!glfwInit())
	{
		return -1;
	}

	// creates the window
	GLFWwindow* window = glfwCreateWindow(
		640,
		640,
		"2d collision animation",
		NULL,
		NULL
	);

	if (!window)
	{
		glfwTerminate();
		return -1;
	}

	glfwMakeContextCurrent(window);
	glfwSwapInterval(1);

	vector<Brick> bricks;
	vector<Circle> circles;

	CreateBricks(bricks);

	// creates two circles with random movement
	float speedX1 = 0.003f + RandomColor() * 0.003f;
	float speedY1 = 0.003f + RandomColor() * 0.003f;

	float speedX2 = 0.003f + RandomColor() * 0.003f;
	float speedY2 = 0.003f + RandomColor() * 0.003f;

	// randomly changes the direction
	if (rand() % 2 == 0)
		speedX1 = -speedX1;

	if (rand() % 2 == 0)
		speedY1 = -speedY1;

	if (rand() % 2 == 0)
		speedX2 = -speedX2;

	if (rand() % 2 == 0)
		speedY2 = -speedY2;

	circles.push_back(Circle(-0.50f, -0.50f, speedX1, speedY1));
	circles.push_back(Circle(0.50f, -0.20f, speedX2, speedY2));

	// runs the animation
	while (!glfwWindowShouldClose(window))
	{
		if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
		{
			glfwSetWindowShouldClose(window, true);
		}

		glClear(GL_COLOR_BUFFER_BIT);

		// moves circles and checks bricks
		for (int i = 0; i < circles.size(); i++)
		{
			circles[i].Move();

			for (int j = 0; j < bricks.size(); j++)
			{
				circles[i].CheckBrickCollision(bricks[j]);
			}
		}

		// checks the circles against each other
		circles[0].CheckCircleCollision(circles[1]);

		// draws the bricks
		for (int i = 0; i < bricks.size(); i++)
		{
			bricks[i].Draw();
		}

		// draws the circles
		for (int i = 0; i < circles.size(); i++)
		{
			circles[i].Draw();
		}

		glfwSwapBuffers(window);
		glfwPollEvents();
	}

	// closes the program
	glfwDestroyWindow(window);
	glfwTerminate();

	return 0;
}