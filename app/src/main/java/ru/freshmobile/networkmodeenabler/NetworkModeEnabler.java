package ru.freshmobile.networkmodeenabler;

import android.os.Build;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

public class NetworkModeEnabler implements IXposedHookInitPackageResources
{

	@Override
	public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable
	{
		if (!resparam.packageName.equals("com.android.phone"))
		{
			return;
		}
		
		resparam.res.setReplacement("com.android.phone", "array", "enabled_networks_except_lte_choices",
									new String[]{"3G only", "3G/2G", "2G"});
		resparam.res.setReplacement("com.android.phone", "array", "enabled_networks_except_lte_values",
									new String[]{"2", "0", "1"});
		resparam.res.setReplacement("com.android.phone", "array", "enabled_networks_4g_choices",
									new String[]{"4G only", "4G/3G/2G", "3G only", "3G/2G", "2G"});
		resparam.res.setReplacement("com.android.phone", "array", "enabled_networks_values",
									new String[]{"11", "9", "2", "0", "1"});
		resparam.res.setReplacement("com.android.phone", "array", "enabled_networks_choices",
									new String[]{"LTE only", "LTE/3G/2G", "3G only", "3G/2G", "2G"});
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			resparam.res.setReplacement("com.android.phone", "string", "network_4G", "4G/3G/2G");
			resparam.res.setReplacement("com.android.phone", "string", "network_lte", "LTE/3G/2G");
			resparam.res.setReplacement("com.android.phone", "string", "network_wcdma_only", "3G only");
			resparam.res.setReplacement("com.android.phone", "string", "network_wcdma_pref", "3G/2G");
			resparam.res.setReplacement("com.android.phone", "string", "network_4G_only", "4G only");
			resparam.res.setReplacement("com.android.phone", "string", "network_lte_only", "LTE only");
		}
	}

}
