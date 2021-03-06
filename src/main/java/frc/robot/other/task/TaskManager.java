package frc.robot.other.task;

import java.util.Hashtable;

import frc.robot.other.Utils;

public class TaskManager {
	private Hashtable<String, TaskRunner> taskRunners = new Hashtable<>();

	public TaskManager(){
		new TaskRunner("main",this);
	}

	public void attachTaskRunner(String key, TaskRunner taskRunner){
		key = Utils.Misc.getAvailableName(taskRunners, key);
		taskRunners.put(key, taskRunner);
	}

	public void attachTaskRunner(TaskRunner taskRunner){
		attachTaskRunner(taskRunner.getName(), taskRunner);
	}

	public TaskRunner getTaskRunner(String key){
		return taskRunners.get(key);
	}

	public TaskRunner getMain(){
		return taskRunners.get("main");
	}

	public void detachTaskRunner(String key){
		taskRunners.remove(key);
	}

	public void start(){
		for (TaskRunner runner: taskRunners.values()) {
			runner.start();
		}
	}

	public void run(){
		for(TaskRunner runner : taskRunners.values())
			runner.run();
	}

	public void stop(){
		for (TaskRunner runner: taskRunners.values()) {
			runner.stop();
		}
	}

	public void printCallStack(){
		System.out.println("Call Stack:");
		System.out.println("\t Runners:");
		for(String key : taskRunners.keySet()){
			System.out.println("\t \t" + key);
			System.out.println("\t \t \t" + "Background:");
			for(String task : taskRunners.get(key).getBackgroundTasks().keySet())
				System.out.println("\t \t \t \t" + task + " - Running: " + taskRunners.get(key).getBackgroundTasks().get(task).isRunning());
			System.out.println("\t \t \t" + "Sequential:");
			for(Task task : taskRunners.get(key).getSequentialTasks())
				System.out.println("\t \t \t \t" + task + " - Running: " + task.isRunning());
		}

	}
}
